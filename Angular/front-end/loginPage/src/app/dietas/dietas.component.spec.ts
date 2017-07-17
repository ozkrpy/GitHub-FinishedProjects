/* tslint:disable:no-unused-variable */
import { async, ComponentFixture, TestBed } from '@angular/core/testing';
import { By } from '@angular/platform-browser';
import { DebugElement } from '@angular/core';

import { DietasComponent } from './dietas.component';

describe('DietasComponent', () => {
  let component: DietasComponent;
  let fixture: ComponentFixture<DietasComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ DietasComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(DietasComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
