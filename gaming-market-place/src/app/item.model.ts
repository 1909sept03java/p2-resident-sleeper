export class Item {
    id: number;
    name: string;
    value: number;
    itemFilename: string;
    index: number;


    constructor(id: number, name: string, value: number, itemFilename: string, index: number) {
        this.id = id;
        this.name = name;
        this.value = value;
        this.itemFilename = itemFilename;
        this.index = index;
        
    }
}