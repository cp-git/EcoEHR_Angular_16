export class StaffRole {
    constructor(public staffRoleId: number,
    			public staffId: number,
                public authority: string,
                public activeFlag: boolean,
                public createdDate: Date,
                public createdBy: string,
                public lastUpdatedDate: Date,
                public lastUpdatedBy: string
    ){
    }
 } 