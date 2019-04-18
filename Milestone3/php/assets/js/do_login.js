function do_login() {
    var uname=$("#username").val();
    var pass=$("#password").val();
    if(uname!="" && pass!="") {
        $.ajax( {
            type:'post',
            url:'../php/elements/do_login.php',
            data:{
            do_login:"do_login",
            uname:uname,
            password:pass
        },  success:function(response) {
                if(response=="success") {
                    window.location.href="https://serenity.ist.rit.edu/~kg8128/spring2019/iste341/project1/index.php";
                } else {
                    // $("#loading_spinner").css({"display":"none"});
                    alert("Incorrect username or password");
                }
            }
        });
    } else {
        alert("Please enter a username and password");
    }
    return false;
}