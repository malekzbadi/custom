
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
    var dateTime = dateFormat();
    var vote;
    var country;
    var city;

    $.ajax('http://ip-api.com/json')
        .then(
            function success(response) {
                //remove console logs when finished this section
                changePage("result.html")
                console.log('User\'s Location Data is ', response);
                vote = number;
                console.log(vote);
                console.log(dateTime);
                console.log(location);
                country = response.country;
                city = response.city;

                setUserIdCookie();

                var userId = getCookie("userId");
                var groupId = getCookie("groupId");
                var Url = 'http://localhost:8080/api/v1/vote/addVote';
                var data = {
                    userId:userId,
                    country:country,
                    city:city,
                    happyScore:vote,
                    datetime:dateTime,
                    groupId:groupId
                };
                $.ajax({
                    url: Url,
                    type: "POST",
                    data: data,
                    success: function(result){
                        console.log(result);
                        console.log("-----Data Sent-----");
                        console.log(data);
                        console.log("-----Status-----");
                        console.log(status);
                    },
                    error:function(error){
                        console.log(error);
                    }
                });
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
    var month = "0" + (date.getMonth() + 1);
    var day =  "0" + date.getDate();
    var hour = date.getHours();
    var min = date.getMinutes();
    var sec = date.getSeconds();
    var milSec = date.getMilliseconds();
    return year + "-" + month + "-" + day + "T" + hour + ":" + min + ":" + sec + "." + milSec;
}

function changePage(HTMLPage) {
    window.location = HTMLPage;
}

function setUserIdCookie(){
    var userId = getCookie('userId');
    if (userId == ''){
        var userId = uuidv4();
        setCookie('userId', userId, 3650);
    } else {
        console.log("Cookie is already set.");
    }
}

function setGroupIdCooke(){
    //If the user clicks a link that his or her boss sent, add that project to his or her cookie.
    //Get the group ID from the database.
    var groupId = "something";
    setCookie("groupId", groupId, 3650);
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