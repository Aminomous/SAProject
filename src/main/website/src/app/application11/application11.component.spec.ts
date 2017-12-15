import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { Application11Component } from './application11.component';

describe('Application11Component', () => {
  let component: Application11Component;
  let fixture: ComponentFixture<Application11Component>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ Application11Component ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(Application11Component);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should be created', () => {
    expect(component).toBeTruthy();
  });
});
