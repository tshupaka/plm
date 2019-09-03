import { Pipe, PipeTransform } from '@angular/core';
import { Young } from 'src/app/model/young.model';
import { YoungFilter } from '../bean/young-filter';


@Pipe({
  name: 'youngFilter'
})
export class YoungPipe implements PipeTransform {


  transform(values: Young[], youngFilter: YoungFilter) {
    if (youngFilter && values) {

      const youngNameFilter: string = youngFilter.youngName ? youngFilter.youngName.toLowerCase() : '';
      let isAccompaniedYesFilter: boolean = youngFilter.isAccompaniedYes;
      let isAccompaniedNoFilter: boolean = youngFilter.isAccompaniedNo;
      let isSensitizedYesFilter: boolean = youngFilter.isSensitizedYes;
      let isSensitizedNoFilter: boolean = youngFilter.isSensitizedNo;
      const accompanyingUserIdFilter: number = youngFilter.accompanyingUserId;
      const accompanyingTypeIdFilter: number = youngFilter.accompanyingTypeId;
      let result = values;
      if (youngNameFilter) {
        result = values.filter((young: Young) => {
          const youngFirstname: string = young.firstname ? young.firstname.toLowerCase() : '';
          const youngLastname: string = young.lastname ? young.lastname.toLowerCase() : '';
          return youngFirstname.includes(youngNameFilter) || youngLastname.includes(youngNameFilter);
        });
      }
      // Si aucun coché, alors idem aucun filtre
      if (!isAccompaniedNoFilter && !isAccompaniedYesFilter) {
        isAccompaniedNoFilter = true;
        isAccompaniedYesFilter = true;
      }

      if (!isSensitizedNoFilter && !isSensitizedYesFilter) {
        isSensitizedNoFilter = true;
        isSensitizedYesFilter = true;
      }

      result = result.filter((young: Young) => {
        if (young.accompanied) {
          return isAccompaniedYesFilter;
        } else {
          return isAccompaniedNoFilter;
        }

      });

      result = result.filter((young: Young) => {
        if (young.sensitized) {
          return isSensitizedYesFilter;
        } else {
          return isSensitizedNoFilter;
        }

      });


      if (accompanyingUserIdFilter) {
        result = result.filter((young: Young) => {
          return young.accompanyingUser && young.accompanyingUser.id == accompanyingUserIdFilter;
        });

      }

      if (accompanyingTypeIdFilter) {
        result = result.filter((young: Young) => {
          console.log(young.accompanyingType);
          return young.accompanyingType && young.accompanyingType == accompanyingTypeIdFilter;
        });

      }
      return result;
    }

  }
}
