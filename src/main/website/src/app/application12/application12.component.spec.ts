import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { Application12Component } from './application12.component';

describe('Application12Component', () => {
  let component: Application12Component;
  let fixture: ComponentFixture<Application12Component>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ Application12Component ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(Application12Component);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should be created', () => {
    expect(component).toBeTruthy();
  });
});
