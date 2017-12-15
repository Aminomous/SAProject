import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { Application3Component } from './application3.component';

describe('Application3Component', () => {
  let component: Application3Component;
  let fixture: ComponentFixture<Application3Component>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ Application3Component ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(Application3Component);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should be created', () => {
    expect(component).toBeTruthy();
  });
});
