export class myItems {
    itemId: number;
    name: string;
    itemFilename: string;
    index: number;


    constructor(itemId: number, name: string, itemFilename: string, index: number) {
        this.itemId = itemId;
        this.name = name;
        this.itemFilename = itemFilename;
        this.index = index
    }
}