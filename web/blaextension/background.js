//script один для всего расширения, является фоновым когда срабатывает ?

chrome.runtime.onMessage.addListener(function(message,sender,sendResponse){
    if (message.action == "sendUsers")
        sendUsers(message);
});

function sendUsers(message){
    $.ajax({
        type: 'post',
        data: JSON.stringify(message.passengers),
        contentType: 'application/json',
        dataType: 'json'
    });
}

function saveTripIdToLocalStorage(){

}