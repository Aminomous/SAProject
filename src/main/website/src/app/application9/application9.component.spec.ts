import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { Application9Component } from './application9.component';

describe('Application9Component', () => {
  let component: Application9Component;
  let fixture: ComponentFixture<Application9Component>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ Application9Component ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(Application9Component);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should be created', () => {
    expect(component).toBeTruthy();
  });
});
