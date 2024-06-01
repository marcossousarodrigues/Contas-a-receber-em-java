
class ValidateInit
{
    getElements()
    {
        const email = document.querySelector(".email");
        const password = document.querySelector(".password");
        const comfirmpassword  = document.querySelector(".comfirmpassword");
        const btnSend = document.querySelector(".btn-send");
        const messageError = document.querySelector(".message-error");
        
        return {email, password, comfirmpassword, btnSend, messageError}
    }
    
    events()
    {
        const {email, password, comfirmpassword, btnSend, messageError} = this.getElements();
        
        btnSend.addEventListener("click", (e)=>{
             
            email.style.border = "none";
            password.style.border = "none";
            comfirmpassword.style.border = "none";
             
            if(!email.value)
            {   
                messageError.innerHTML = "O campo e-mail é obrigatorio, por favor preencher";
                email.style.border = "3px solid red";
                e.preventDefault();
                return;
            }
            if(!password.value)
            {
                messageError.innerHTML = "O campo senha é obrigatorio, por favor preencher";
                password.style.border = "3px solid red";
                e.preventDefault();
                return;
            }   
            if(!comfirmpassword.value)
            {
                messageError.innerHTML = "O campo confimação da senha é obrigatorio, por favor preencher";
                comfirmpassword.style.border = "3px solid red";
                e.preventDefault();
                return;
            }
            if(password.value !== comfirmpassword.value)
            {
                messageError.innerHTML = "O campo senha e confirmação de senha precisam ser iguais";
                password.style.border = "3px solid red";
                comfirmpassword.style.border = "3px solid red";
                e.preventDefault();
                return;
            }
           
        });
    }
    
   
}

validate = new ValidateInit();

validate.events();