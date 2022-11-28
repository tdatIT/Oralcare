$('#confirm-password').on('input', function (e) {
    var pass = $('#password').val();
    var confirm = $("#confirm-password").val();

    if (confirm != pass) {
        $("#error-alert").text("Vui lòng nhập khớp mật khẩu")
        $("#success-alert").text("")
    } else {
        $("#success-alert").text("Mật khẩu khớp")
        $("#error-alert").text("")
    }
})

$('register-form').submit(function(e){
    e.preventDefault();
    var pass = $('#password').val();
    var confirm = $("#confirm-password").val();
    if(confirm != pass) {
        $('#alert-register').text('Vui lòng kiểm tra lại thông tin')
    }else{
        var form = $(this)
        $.ajax({
            method:'POST',
            url:'register',
            data:form.serialize(),
            success: function(data){
                window.location.replace("http://stackoverflow.com");
            }
        })
    }
   
})