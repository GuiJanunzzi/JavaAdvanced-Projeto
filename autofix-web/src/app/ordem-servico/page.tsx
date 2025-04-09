import { getOrdemServico } from '@/actions/ordem-servico-actions'
import Cabecalho from '@/components/Cabecalho'
// import OrdemServicoItem from '@/components/ordem-servico-item'
import {
  Table,
  TableBody,
  TableCaption,
  TableCell,
  TableHead,
  TableHeader,
  TableRow,
} from "@/components/ui/table"

export default async function page() {

  const dados: OrdemServico[] = await getOrdemServico()

  console.log(dados);
  
  return (
    <>
      <Cabecalho ativo="ordem-servico" />
      <main className='flex justify-center'>
        <div className='bg-gray-400 p-6 m-6 rounded w-full max-w-4xl text-center'>
          <h2 className='text-2xl font-bold mb-4'>Ordem de Serviço</h2>
          <Table>
          <TableCaption>Lista de ordens de serviço.</TableCaption>
          <TableHeader >
            <TableRow>
              <TableHead>Descrição</TableHead>
              <TableHead>Valor Total</TableHead>
              <TableHead>Status</TableHead>
            </TableRow>
          </TableHeader>
          <TableBody>
          {dados.map(ordemServico =>(
            <TableRow key={ordemServico.id} className='text-left'>
            <TableCell>{ordemServico.descricao}</TableCell>
            <TableCell>{ordemServico.valorTotal}</TableCell>
            <TableCell>{ordemServico.status}</TableCell>
          </TableRow>
          ))}
          </TableBody>
        </Table>
        </div>
      </main>
    </>
  )
}
