import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { Information8Component } from './information8.component';

describe('Information8Component', () => {
  let component: Information8Component;
  let fixture: ComponentFixture<Information8Component>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ Information8Component ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(Information8Component);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should be created', () => {
    expect(component).toBeTruthy();
  });
});
