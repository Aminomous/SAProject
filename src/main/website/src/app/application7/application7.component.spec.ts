import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { Application7Component } from './application7.component';

describe('Application7Component', () => {
  let component: Application7Component;
  let fixture: ComponentFixture<Application7Component>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ Application7Component ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(Application7Component);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should be created', () => {
    expect(component).toBeTruthy();
  });
});
