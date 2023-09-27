import { Component, OnInit } from '@angular/core';
import { ApiService } from '../../api.service';

@Component({
  selector: 'app-segurados',
  templateUrl: './segurados.component.html',
  styleUrls: ['./segurados.component.scss']
})
export class SeguradosComponent implements OnInit {
  data: any;

  constructor(private apiService: ApiService) { }

  ngOnInit(): void {
    this.apiService.getData().subscribe((result) => {
      this.data = result;
      console.log(this.data);
    });
  }

}
