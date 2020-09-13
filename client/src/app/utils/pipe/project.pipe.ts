import { Pipe, PipeTransform } from '@angular/core';
import { Awareness } from 'src/app/model/awareness.model';
import { Project } from 'src/app/model/project.model';
/**
 * Pipe used to filter projects from a given name
 */
@Pipe({
  name: 'projectFilter'
})
export class ProjectPipe implements PipeTransform {


  transform(value: Project[], searchTerm: string = '') {
    if (searchTerm !== '') {
      const result = value.filter((project: Project) => project.name.toLowerCase().includes(searchTerm));
      return result;
    } else {
      return value;
    }
  }
}
