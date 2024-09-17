export class ICD10 {
    constructor(public ICD10Code: string, 
        public Description: string, 
        public SearchInclusion: string,
        public ClinicalNotes: string,
        public primary:boolean=false,
        public icdgroupName:string
    ){}
}