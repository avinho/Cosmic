import { AfterViewInit, Component, ViewChild } from '@angular/core';
import { MatTableDataSource } from '@angular/material/table';
import { DATA_SEGURADORAS } from './data-table';
import { MatPaginator } from '@angular/material/paginator';

@Component({
  selector: 'app-seguradoras',
  templateUrl: './seguradoras.component.html',
  styleUrls: ['./seguradoras.component.scss']
})
export class SeguradorasComponent implements AfterViewInit {
  public dataSource = new MatTableDataSource(DATA_SEGURADORAS);
  public displayedColumns: string[] = ['nome', 'gerente', 'telefone', 'email', 'actions'];

  resultsLength = 0;

  @ViewChild(MatPaginator) paginator!: MatPaginator;

  ngAfterViewInit() {
    this.dataSource.paginator = this.paginator;
  }

  applyFilter(event: Event) {
    const filterValue = (event.target as HTMLInputElement).value;
    this.dataSource.filter = filterValue.trim().toLowerCase();
  }

  editarElemento(element: any) {
    // Implemente a ação de edição aqui
    console.log('Editar', element);
  }

  excluirElemento(element: any) {
    // Implemente a ação de exclusão aqui
    console.log('Excluir', element);
  }
}
