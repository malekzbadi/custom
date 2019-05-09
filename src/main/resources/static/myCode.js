
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
    var uuid =  uuidv4();
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
                console.log(uuid);
                console.log(vote);
                console.log(dateTime);
                console.log(location);
                country = response.country;
                city = response.city;
            },

            function fail(data, status) {
                console.log('Request failed.  Returned status of',
                    status);
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


