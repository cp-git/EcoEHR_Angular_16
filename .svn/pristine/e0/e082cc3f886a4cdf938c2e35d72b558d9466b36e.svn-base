import {AbstractControl} from '@angular/forms';

export class passwordValidation{

    static passMatch(AC: AbstractControl){

        let newpassword=AC.get('newpassword').value;
        let confirmpassword=AC.get('confirmpassword').value;
        if((newpassword!=confirmpassword) && ((newpassword && confirmpassword)!=null))
        {
            AC.get('confirmpassword').setErrors( {passMatch: true} )
           
        }
        else{
             return null;
        }
        }    
}

