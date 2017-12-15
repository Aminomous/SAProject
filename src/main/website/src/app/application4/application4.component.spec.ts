import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { Application4Component } from './application4.component';

describe('Application4Component', () => {
  let component: Application4Component;
  let fixture: ComponentFixture<Application4Component>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ Application4Component ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(Application4Component);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should be created', () => {
    expect(component).toBeTruthy();
  });
});
