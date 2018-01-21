import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { Information7Component } from './information7.component';

describe('Information7Component', () => {
  let component: Information7Component;
  let fixture: ComponentFixture<Information7Component>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ Information7Component ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(Information7Component);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should be created', () => {
    expect(component).toBeTruthy();
  });
});
