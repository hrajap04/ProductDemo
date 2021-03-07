import { Component, OnInit } from '@angular/core';
import { BasicDataService } from 'src/app/services/basic-data.service';

@Component({
  selector: 'app-header',
  templateUrl: './header.component.html',
  styleUrls: ['./header.component.scss']
})
export class HeaderComponent implements OnInit {

  constructor(public basicDataService: BasicDataService) { }

  ngOnInit(): void {
  }


}
