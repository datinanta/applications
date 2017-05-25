import { OperaCategory } from './opera-category'
import { OperaMaterial } from './opera-material'
import { OperaSizes } from './opera-sizes'
import { GpsPoint } from './gps-point'
import { Media } from './media'


export class Opera {
    id: string = "";
    author: string = "Pinuccio Sciola";
    name: string;
    description: string;
    category: string;
    material: string;
    dimensions: OperaSizes;
    position: GpsPoint;
    medias: Media[];

    public static empty(): Opera {
        return {
            dimensions: {} as OperaSizes,
            position: {} as GpsPoint,
            medias: []
        } as Opera;
    }
}

export class OperaPreview{
    opera: Opera;
    previewImg: string;
}