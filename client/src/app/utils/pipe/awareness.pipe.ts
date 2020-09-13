import { Pipe, PipeTransform } from '@angular/core';
import { Awareness } from 'src/app/model/awareness.model';
/**
 * Pipe used to filter awarenesses from a given name
 */
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
