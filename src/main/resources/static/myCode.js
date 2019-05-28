
!function(d,s,id){var js,fjs=d.getElementsByTagName(s)[0];if(!d.getElementById(id)){js=d.createElement(s);js.id=id;js.src='https://weatherwidget.io/js/widget.min.js';fjs.parentNode.insertBefore(js,fjs);}}(document,'script','weatherwidget-io-js');

function firstButton() {
    ipLookUp(1);
}

function secondButton() {
    ipLookUp(2);
}

function thirdButton() {
    ipLookUp(3);
}

function fourthButton() {
    ipLookUp(4);
}

function fifthButton() {
    ipLookUp(5);
}

function ipLookUp (number) {
    var datetime;
    var vote;
    var country;
    var city;

    var d = new Date();
    datetime = dateFormat();

    var responseStatusString;

    $.ajax('http://ip-api.com/json')
        .then(
            function success(response) {
                //remove console logs when finished this section
                console.log('User\'s Location Data is ', response);
                vote = number;
                country = response.country;
                city = response.city;

                setUserIdCookie();

                var userId = getCookie("userId");
                var Url = 'http://localhost:8080/api/v1/vote/addVote';
                var data = {
                    userId:userId,
                    country:country,
                    city:city,
                    happyScore:vote,
                    datetime:datetime,
                };
                $.ajax({
                    url: Url,
                    type: "POST",
                    data: data,
                    async: false,
                    dataType: "JSON",
                    success: function(result){
                        responseStatusString = result['responseText'];
                    },
                    error: function(error){
                        responseStatusString = error['responseText'];
                    }
                });
                var url = "result.html?status=" + responseStatusString;
                changePage(url);
            },
            function fail(data, status) {
                console.log('Request failed.  Returned status of', status);
            }
        );
}

function uuidv4() {
    return 'xxxxxxxx-xxxx-4xxx-yxxx-xxxxxxxxxxxx'.replace(/[xy]/g, function(c) {
        var r = Math.random() * 16 | 0, v = c == 'x' ? r : (r & 0x3 | 0x8);
        return v.toString(16);
    });
}

function dateFormat(){
    var date = new Date();
    var year = date.getFullYear();
    var month = date.getMonth() + 1;
    var day =  date.getDate();
    var hour = date.getHours();
    var min = date.getMinutes();
    var sec = date.getSeconds();

    if (month < 10){
        month = "0" + month;
    }
    if (day < 10){
        day = "0" + day;
    }
    return year + "-" + month + "-" + day + "T" + hour + ":" + min + ":" + sec;
}

function changePage(HTMLPage) {
    window.location = HTMLPage;
}

function setUserIdCookie(){
    var userId = getCookie('userId');
    if (userId == '' || userId === undefined){
        var userId = uuidv4();
        setCookie('userId', userId, 3650);
    } else {
        console.log("Cookie is already set.");
    }
}

function setCookie(cname, cvalue, exdays) {
    var d = new Date();
    d.setTime(d.getTime() + (exdays * 24 * 60 * 60 * 1000));
    var expires = "expires="+d.toUTCString();
    document.cookie = cname + "=" + cvalue + ";" + expires + ";path=/";
}

function getCookie(cname) {
    try {
        var name = cname + "=";
        var ca = document.cookie.split(';');
        for (var i = 0; i < ca.length; i++) {
            var c = ca[i];
            while (c.charAt(0) == ' ') {
                c = c.substring(1);
            }
            if (c.indexOf(name) == 0) {
                return c.substring(name.length, c.length);
            }
        }
    }
    catch(error) {
        return "";
    }
}