export class ClinicLocation {
    constructor(public locationId: number, 
                public locationName: string,
                public addressStreet: string,  
                public addressDoorNo: string,
                public addressCity: string,
                public addressState: string,
                public addressZip: string,
                public contactName:string,
                public contactEmail:string,
                public primaryNo: string,
                public faxNo: string,  
                public einNumber: string,
                public activeFlag: boolean,
                public organizationId: number,
                 public buildingNo: string,
                public createdDate: Date,
                public createdBy: string,
                public lastUpdatedDate: Date,
                public lastUpdatedBy: string) { 
    }
 } 