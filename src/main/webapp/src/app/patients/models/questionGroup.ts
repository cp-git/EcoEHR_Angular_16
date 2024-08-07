export class QuestionGroup {
    constructor(public questionGroupId: number, 
                public systemId: number, 
                public questionGroupName: string,
                public questionGroupOrder: number,
                public questionCount: number,
                public activeFlag: any,
                public createdDate: Date,
                public createdBy: string,
                public lastUpdatedDate: Date,
                public lastUpdatedBy: string) { 
    }
 } 