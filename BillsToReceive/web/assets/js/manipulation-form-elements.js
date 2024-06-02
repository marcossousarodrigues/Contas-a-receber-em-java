

class manipulationElements
{
    selectElements()
    {
        const dt_emission = document.querySelector(".dt_emission");
        const options_field = document.querySelector(".field");
        const name_field = document.querySelector(".name-field");
        const dt_payment = document.querySelector(".dt_payment");
        const pay = document.querySelector(".pay");
        const product_id = document.querySelector(".product_id");
        const name_product = document.querySelector(".name_product");
        const description_product = document.querySelector(".description_product");
        const client_id = document.querySelector(".client_id");
        const client_name = document.querySelector(".client_name");
        const nature_id = document.querySelector(".nature_id");
        const nature_name = document.querySelector(".nature_name");
        const product_value = document.querySelector(".product_value");
        const title_value = document.querySelector(".title_value");
        
        
        return {
                dt_emission, options_field, name_field, dt_payment, 
                pay, product_id, name_product, description_product,
                client_id, client_name, nature_id, nature_name, product_value,
                title_value
            }
    }
    
    changeFieldType()
    {
        
        const {options_field, name_field} = this.selectElements();
        
        if(options_field == null ) return;
        
        options_field.addEventListener('change', ()=> {
            
            if (options_field.value === 'dt_payment' || options_field.value === 'dt_expiration') {
                name_field.type = 'date';
            } else {
                name_field.type = 'text';
                name_field.value = '';
            }
        });
    }
    
    changePayField()
    {
        
        const {pay, dt_payment} = this.selectElements();
        
        if(dt_payment == null && pay == null ) return;
        
        pay.addEventListener("change", ()=> {
            if (pay.value === "1") {
                dt_payment.readonly = false;
                dt_payment.style.backgroundColor = '#FFF';
                const today = new Date();
                dt_payment.value = this.formatDate(today);
            } else {
               dt_payment.readonly = true;
               dt_payment.style.backgroundColor = '#CCC';
               dt_payment.value = "";
            }
        });
    }
    
    changeSelects(){
        
        const {product_id, name_product, description_product,
              client_id, client_name, nature_id, nature_name,
              product_value, title_value
        } = this.selectElements();
        
        
        if(product_id == null && name_product == null) return;
        
        // product
        this.twoSelects(product_id, name_product)
        this.twoSelects(product_id, description_product)
        this.twoSelects(name_product, description_product)
        
        // client
        this.twoSelects(client_id, client_name)
        
        // nature
        this.twoSelects(nature_id, nature_name)
        
        if(product_value == null) return;
        //value product 
        this.twoSelects(product_id, product_value)
        this.twoSelects(name_product, product_value)
        this.twoSelects(description_product, product_value)
        
        this.eventAddValue(product_id, title_value, "");
        this.eventAddValue(name_product, title_value, "");
        this.eventAddValue(description_product, title_value, "");
        
        title_value.addEventListener('click', function() {
            title_value.value = product_value.options[product_value.selectedIndex].text;
        });
       
        
    }
    
    twoSelects(select1, select2)
    {
        function syncSelects(select1, select2) {
            const value = select1.value;
            select2.value = value;
        }

        select1.addEventListener('change', function() {
            syncSelects(select1, select2);
        });

        select2.addEventListener('change', function() {
            syncSelects(select2, select1);
        });
     
        // Sincronizar inicialmente os selects
        syncSelects(select1, select2);
        
    }
    
    eventAddValue(element1, element2, value)
    {
        element1.addEventListener('click', function() {
            element2.value = value;
        });
    }
    
    addCurrentDate()
    {
        document.addEventListener('DOMContentLoaded', (event) => {
            
            const {dt_emission} = this.selectElements();
            
            if( dt_emission == null ) return;
            
            const today = new Date();
            const formattedDate = this.formatDate(today);
            
            // Define o valor do campo de entrada de data
            dt_emission.value = formattedDate;
        });
    }
    
    formatDate(today)
    {
        // Formata a data no padrão ISO (YYYY-MM-DD)
        const year = today.getFullYear();
        const month = String(today.getMonth() + 1).padStart(2, '0');
        const day = String(today.getDate()).padStart(2, '0');
        return `${year}-${month}-${day}`;
    }
    
}

const initElements = new manipulationElements;

// adiciona a data atual ao campo data de emissão
initElements.addCurrentDate();

//adicionando tipo de campo de acordo com a seleção do tipo
initElements.changeFieldType();

// habilitando e desabilidado o campo data de pagamento de acordo com a seleção do campo
initElements.changePayField();

//
initElements.changeSelects();