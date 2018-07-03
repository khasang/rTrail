var setNumberOnlineUsers = function () {
    $.ajax({
        url: "/admin/users/get/online",
        success: function (response) {
            try {
                var json = JSON.parse(response);
                var numberOnlineUsers = parseInt(json) || 0;
                if (numberOnlineUsers > 0) {
                    $("#rt-user-info").removeClass().addClass("rt-icon-online");
                } else {
                    $("#rt-user-info").removeClass().addClass("rt-icon-offline");
                }
                document.getElementById("rt-users-num").innerHTML = numberOnlineUsers + "";
            } catch (e) {
                $("#rt-user-info").removeClass().addClass("rt-icon-offline");
                document.getElementById("rt-users-num").innerHTML = "";
            } finally {
                setTimeout(setNumberOnlineUsers, 10000);
            }
        },
        complete: function (jqXHR, textStatus) {
        }
    });
};

$(function () {
    setNumberOnlineUsers();
});