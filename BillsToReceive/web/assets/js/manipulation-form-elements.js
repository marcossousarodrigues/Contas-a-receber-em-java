

class manipulationElements
{
    selectElements()
    {
        const dt_emission = document.querySelector(".dt_emission");
        const options_field = document.querySelector(".field");
        const name_field = document.querySelector(".name-field")
        
        return {dt_emission, options_field, name_field}
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
    
    
    addCurrentDate()
    {
        document.addEventListener('DOMContentLoaded', (event) => {
            
            const {dt_emission} = this.selectElements();
            
            if( dt_emission == null ) return;
            
            const today = new Date();

            // Formata a data no padrão ISO (YYYY-MM-DD)
            const year = today.getFullYear();
            const month = String(today.getMonth() + 1).padStart(2, '0');
            const day = String(today.getDate()).padStart(2, '0');

            const formattedDate = `${year}-${month}-${day}`;

            // Define o valor do campo de entrada de data
            dt_emission.value = formattedDate;
        });
    }
    
}

const initElements = new manipulationElements;

initElements.addCurrentDate();
initElements.changeFieldType();