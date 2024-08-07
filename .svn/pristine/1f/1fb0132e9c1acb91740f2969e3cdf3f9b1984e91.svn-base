import { ErrorHandler, Injectable, Injector } from "@angular/core";
import { Router, ActivatedRoute } from '@angular/router';
import { Data } from "app/data";
@Injectable()
export class GlobalErrorHandler implements ErrorHandler {
    router: any;

    constructor(private data: Data, private injector: Injector) { }

    handleError(errorCode) {
        // Custom error handling logic
        console.log("errorCode:" + errorCode);
        let router = this.injector.get(Router);
        console.log('URL: ' + router.url);

        //Getting Router via Injector
        if (!this.router) this.router = this.injector.get(Router)
        this.data.storage = {
            successMessageData: errorCode,
            url: router.url
        }
        if (this.router.url === '/ccmsummary') {
        }
        else {
            this.router.navigate(['./error']);
        }

    }
}