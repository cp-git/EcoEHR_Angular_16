
import { Injectable } from '@angular/core';


@Injectable()
export class Data {
    successMsg: any;
    statusCode: number;
    msgName: any;
    messageType: any;
    public storage:any;

    public constructor() { }

    public static errorCodeMethod(errorCode){
        if(ErrorCode.errorCodeList.indexOf(errorCode, 0) === -1){
          throw new Error(errorCode);
        }
    }
}

export class ErrorCode{
    public static errorCodeList:Array<number>=[409];
}