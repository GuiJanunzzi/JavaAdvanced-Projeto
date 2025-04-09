import {
  Table,
  TableBody,
  TableCaption,
  TableCell,
  TableHead,
  TableHeader,
  TableRow,
} from "@/components/ui/table"

interface OrdemServicoProps {
  ordemServico: OrdemServico
}

export default function OrdemServicoItem({ ordemServico }: OrdemServicoProps) {
  return (
    <div className="flex justify-between mt-2">
      <div className="flex justify-center items-center">
        <Table>
          <TableCaption>Lista de ordens de serviço.</TableCaption>
          <TableHeader>
            <TableRow>
              <TableHead>Descrição</TableHead>
              <TableHead>Valor Total</TableHead>
              <TableHead>Status</TableHead>
            </TableRow>
          </TableHeader>
          <TableBody>
            <TableRow key={ordemServico.id}>
              <TableCell>{ordemServico.descricao}</TableCell>
              <TableCell>{ordemServico.valorTotal}</TableCell>
              <TableCell>{ordemServico.status}</TableCell>
            </TableRow>
          </TableBody>
        </Table>
      </div>
    </div>
  )
}
