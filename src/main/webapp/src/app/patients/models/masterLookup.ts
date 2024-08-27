export class MasterLookup {
    constructor(public lookupId: number, 
                public lookupType: string, 
                public lookupCode: string,
                public lookupDesc: string,
                public activeFlag: boolean,
                public organizationId: number,
                public createdDate: Date,
                public createdBy: string,
                public lastUpdatedDate: Date,
                public lastUpdatedBy: string) { 
    }
 }