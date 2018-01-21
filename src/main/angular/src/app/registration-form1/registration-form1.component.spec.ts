import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { RegistrationForm1Component } from './registration-form1.component';

describe('RegistrationForm1Component', () => {
  let component: RegistrationForm1Component;
  let fixture: ComponentFixture<RegistrationForm1Component>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ RegistrationForm1Component ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(RegistrationForm1Component);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should be created', () => {
    expect(component).toBeTruthy();
  });
});
