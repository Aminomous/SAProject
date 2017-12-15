import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { Application5Component } from './application5.component';

describe('Application5Component', () => {
  let component: Application5Component;
  let fixture: ComponentFixture<Application5Component>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ Application5Component ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(Application5Component);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should be created', () => {
    expect(component).toBeTruthy();
  });
});
