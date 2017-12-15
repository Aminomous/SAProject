import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { Application10Component } from './application10.component';

describe('Application10Component', () => {
  let component: Application10Component;
  let fixture: ComponentFixture<Application10Component>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ Application10Component ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(Application10Component);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should be created', () => {
    expect(component).toBeTruthy();
  });
});
