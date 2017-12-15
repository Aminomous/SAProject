import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { Application6Component } from './application6.component';

describe('Application6Component', () => {
  let component: Application6Component;
  let fixture: ComponentFixture<Application6Component>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ Application6Component ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(Application6Component);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should be created', () => {
    expect(component).toBeTruthy();
  });
});
