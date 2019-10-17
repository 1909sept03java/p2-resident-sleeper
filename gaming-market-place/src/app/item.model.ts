export class Item {
    id: number;
    name: string;
    value: number;
    itemFilename: string;


    constructor(id: number, name: string, value: number, itemFilename: string) {
        this.id = id;
        this.name = name;
        this.value = value;
        this.itemFilename = itemFilename;
        
    }
}