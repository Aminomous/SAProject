import { AbstractControl } from "@angular/forms";

export function PasswordValidator(c: AbstractControl): any {
    if (!c.parent || !c) return;
    const pwd = c.parent.get('password');
    const cpwd = c.parent.get('passwordConfirm')

    if (!pwd || !cpwd) return;
    if (pwd.value !== cpwd.value) {
        return { invalid: true };

    }
}