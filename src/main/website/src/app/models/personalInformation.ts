import { Q6 } from "./q6";

export class PersonalInformation {
    ID: string;
    titleTH: string;
    fNameTH: string;
    lNameTH: string;
    fNameEN: string;
    lNameEN: string;
    address: string;
    email: string;
    phoneNumber: string;
    dateOfBirth: Date;
    placeOfBirth: string;
    weight: number;
    heigth: number;
    nationality: string;
    race: string;
    religion: string;
    profNo: string;
    militaryStatus: string;
    maritalStatus: string ;
    emergencyContact: string;
    toeicScore: number;
    toeicYear: number;
    toeflScore: number;
    toeflYear: number;
    word: number;
    excel: number;
    powerponumber: number;
    driveCar: boolean;
    ownCar: boolean;
    driveLicenseCar: string;
    rideMotocycle: boolean;
    ownMotocycle: boolean;
    driveLicenseMotocycle: boolean;
    hobby: string;
    q1: boolean;
    q2: boolean;
    q3: boolean;
    q4: boolean;
    q5: boolean;
    q6: Q6[];
}