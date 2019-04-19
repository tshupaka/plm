import { Pipe, PipeTransform } from '@angular/core';
import { Awareness } from 'src/app/model/awareness.model';

@Pipe({
  name: 'awarenessFilter'
})
export class AwarenessPipe implements PipeTransform {


  transform(value: Awareness[], searchTerm: string = '') {
    if (searchTerm !== '') {
      const result = value.filter((awareness: Awareness) => awareness.name.toLowerCase().includes(searchTerm));
      return result;
    } else {
      return value;
    }
  }
}
