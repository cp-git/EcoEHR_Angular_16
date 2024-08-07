import { Component } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { Data } from 'app/data';
@Component({
    selector: 'ehr-error',
    templateUrl: './error.component.html'
})
export class GlobalErrorComponent {
    errorCode: number;
    url: string="";
    constructor(private data:Data, private route:ActivatedRoute){

    }
    ngOnInit(){
        if(this.data.storage!==undefined){
            this.errorCode=this.data.storage.successMessageData;
            this.url = this.data.storage.url;
            console.log("Error Code:  "+ this.errorCode);
        }
}
}