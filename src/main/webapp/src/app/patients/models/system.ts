export class System {
    constructor(public systemId: number, 
                public systemType: string, 
                public systemCode: string,
                public systemDesc: string,
                public systemOrder: number,
                public questionGroupCount: string,
                public activeFlag: any,
                public createdDate: Date,
                public createdBy: string,
                public lastUpdatedDate: Date,
                public lastUpdatedBy: string,
                public externalLinks: string) { 
    }
 } 