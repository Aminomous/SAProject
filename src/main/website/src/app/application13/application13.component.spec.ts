import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { Application13Component } from './application13.component';

describe('Application13Component', () => {
  let component: Application13Component;
  let fixture: ComponentFixture<Application13Component>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ Application13Component ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(Application13Component);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should be created', () => {
    expect(component).toBeTruthy();
  });
});
