import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { Application14Component } from './application14.component';

describe('Application14Component', () => {
  let component: Application14Component;
  let fixture: ComponentFixture<Application14Component>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ Application14Component ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(Application14Component);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should be created', () => {
    expect(component).toBeTruthy();
  });
});
