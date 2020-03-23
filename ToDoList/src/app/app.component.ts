import { Component } from '@angular/core';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  title = 'ToDoList';

  ngOnInit() {
    let browserData = localStorage.getItem('tareas');
    if (browserData != null) {
      this.toDo = JSON.parse(browserData);
      this.totalTareas = this.toDo.length;
    }
    if (browserData == null) {
      this.setInitialData();
      this.totalTareas = 0;
    }
  }

  toDo = [];
  totalTareas;
  //name = 'Efrén';

  addToDo(value) {
    if (value.length < 10) {
      alert("Ingrese más de 10 caracteres");

    } else {
      let pos = this.toDo.length;
      this.toDo.push({
        id: pos + 1,
        tarea: value,
        status: false
      });
    }
    console.log(this.toDo);
    this.saveLocalStorage();
    this.totalTareas = this.toDo.length;
  }

  setInitialData() {
    this.toDo.push({
      id: 1,
      tarea: "Limpiar la cocina",
      status: true
    });
  }

  saveLocalStorage() {
    localStorage.setItem('tareas', JSON.stringify(this.toDo));
  }

  changeStatus(event, id) {
    let newStatus = event.target.checked;
    for (let i = 0; i < this.toDo.length; i++) {
      if (this.toDo[i].id == id) {
        this.toDo[i].status = newStatus;
      }
    }
    this.saveLocalStorage();
    //console.log(this.toDo);
  }

  deleteTareas(id) {
    let pos = this.toDo.indexOf(id);
    this.toDo.splice(pos - 1, 1);
    console.log(this.toDo);
    this.saveLocalStorage();
    this.totalTareas = this.toDo.length;
  }
}
