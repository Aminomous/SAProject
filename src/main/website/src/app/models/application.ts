import { QH1 } from "./qh1";
import { Apprenticeship } from "./apprenticeship";
import { Education } from "./education";
import { Employee } from "./employee";
import { EmploymentRecord } from "./employmentRecord";
import { FamilyDetail } from "./familyDetail";
import { Hospital } from "./hospital";
import { LanguageAbility } from "./languageAbility";
import { PersonalInformation } from "./personalInformation";
import { ReferencePerson } from "./referencePerson";

export class Application {
    refnum: number;
    date: Date;
    position1: string;
    position2: string;
    workInShift: boolean;
    workerType: string;
    salary: number;
    startingDate: Date;
    qh1: QH1[];
    QH2: string;
    QH3: string;
    relativeWorkInHospital: string;
    additionalInformation: string;
    apprenticeships: Apprenticeship[];
    educations: Education[];
    employee: Employee;
    employmentRecords: EmploymentRecord[];
    familyDetails: FamilyDetail[];
    hospitals: Hospital[];
    languageAbilities: LanguageAbility[];
    personalInformation: PersonalInformation;
    referencePeople: ReferencePerson[];
    applicationStatus1: boolean;
    applicationStatus2: boolean;
    applicationStatus3: boolean;
    applicationStatus4: boolean;
    applicationStatus5: boolean;
}