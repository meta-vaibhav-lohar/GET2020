export interface Tasks {
    task: Task[];
}

export interface Task {
    id: number;
    title: string;
    description: string;
    status: string;
}
