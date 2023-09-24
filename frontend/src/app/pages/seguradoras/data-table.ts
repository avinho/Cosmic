export interface Seguradoras {
  nome: string;
  gerente: string;
  telefone: string;
  email: string;
}

export const DATA_SEGURADORAS: Seguradoras[] = [
  { nome: "Porto Seguro", gerente: "Bruno", telefone: "(79)9999-9999", email: "email@example.com"},
  { nome: "Allianz", gerente: "Ana", telefone: "(11)8888-8888", email: "ana@example.com"},
  { nome: "Bradesco Seguros", gerente: "Carlos", telefone: "(21)7777-7777", email: "carlos@example.com"},
  { nome: "SulAmérica", gerente: "Daniela", telefone: "(51)6666-6666", email: "daniela@example.com"},
  { nome: "Tokio Marine", gerente: "Eduardo", telefone: "(31)5555-5555", email: "eduardo@example.com"},
  { nome: "Mapfre Seguros", gerente: "Fernanda", telefone: "(41)4444-4444", email: "fernanda@example.com"},
  { nome: "HDI Seguros", gerente: "Gabriel", telefone: "(61)3333-3333", email: "gabriel@example.com"},
  { nome: "Liberty Seguros", gerente: "Helena", telefone: "(48)2222-2222", email: "helena@example.com"},
];
