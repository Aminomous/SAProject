import { QH1 } from "./qh1";
import { Hospital } from "./hospital";
import { PersonalInformation } from "./personalInformation";
import { ReferencePerson } from "./referencePerson";

export class Application {
    refnum: number;
    date: string;
    position1: string;
    position2: string;
    workInShift: number;
    workerType: string;
    salary: number;
    startingDate: Date;
    qh1: QH1[];
    qh2: string;
    qh3: string;
    relativeWorkInHospital: string;
    additionalInformation: string;
    hospitals: Hospital[];
    personalInformation: PersonalInformation;
    referencePeople: ReferencePerson[];
    applicationStatus6: number;
}